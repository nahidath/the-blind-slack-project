package controller.communication;

import database.DAO;
import database.DAOFactory;
import model.SlackSystem;
import model.communication.Workspace;
import model.communication.WorkspaceChannel;
import model.user.User;

import java.sql.SQLException;

public class ChannelServiceDAO{

    private DAO<WorkspaceChannel> DAOChannel;
    private SlackSystem slackSystem;

    public ChannelServiceDAO(SlackSystem slackSystem) throws SQLException {
        DAOChannel= DAOFactory.workspaceChannel();
        this.slackSystem=slackSystem;
    }
    


    //function called by a profile
    public WorkspaceChannel createCh(String idChannel) throws SQLException {
        WorkspaceChannel channel,ch;

        ch = DAOChannel.select(idChannel);
        if(ch != null) {
            System.out.println("this channel name already exist, please choose another name");
            return null;
        }

        channel = new WorkspaceChannel(idChannel);
        channel.setWorkspaceId(slackSystem.getCurrentConnectedWorkspace().getId());

        ch = DAOChannel.insert(channel);
        if(ch==null){
            return null;
        }

        return channel;
    }


    /**********************************************************/



     //called by a profile
    public void quitCh(WorkspaceChannel channel){
        //we actually can't quit a channel
    }


    //called by a profile
     public void deleteCh(WorkspaceChannel channel){

     if(slackSystem.getCurrentConnectedProfile().getIsWorkspaceAdmin()){
         DAOChannel.delete(channel);
         System.out.println("this channel has been deleted successfully");
         }else {
         System.out.println("this channel couldn't be deleted");
         }
     }

    /*public void editCh(WorkspaceChannel channel) throws SQLException {//called by a profile
        String newName;
        Scanner buff;
        WorkspaceChannel wsChannel;

        boolean exist = false;
        if(connectedProfile.getIsAdminCh()==0){
            System.out.println("you don't have any right on this channel");
        }else{
            System.out.println("Enter the new name of this channel");
            do {
                buff = new Scanner(System.in);
                newName = buff.nextLine();
                wsChannel = DAOChannel.select(newName);
                if(channel!=null) {
                    exist=true;
                    System.out.println("this channel name already exist, please choose another one");
                }

            }while(exist);
            //updating the id channel for all the messages
            channel.setName(newName);
            wsChannel = DAOChannel.update(channel);
            System.out.println("The channel informations has been changed successfully");

        }
    }

    public Message sendChannelMsg(WorkspaceChannel channel){//called by a profile
        Message message;
        String content;
        Scanner buffer;
        Date date = new Date();

        System.out.println("Enter the content of your message");
        buffer = new Scanner(System.in);
        content = buffer.next();
        message = new Message(connectedProfile,content);
        message.setCreatedAt(date);
        message.setIdCh(channel.getId());
        //channel.getConversation().add(message);
        return DAOMessageChannel.insert(message);
    }

    public void deleteChannelMsg(Message msg){//called by a profile
        if(msg.getIdSenderMessage()== connectedProfile.getId()){
            DAOMessageChannel.delete(msg);
            System.out.println("the message has been deleted succefully");
        }else{
            System.out.println("The message that you are trying to delete is not yours, please select a message that has been sent by you");
        }
    }

    public Message editChannelMsg(Message msg){
        Message message;
        String newContent;
        Scanner buffer;
        Date date = new Date();
        System.out.println("Enter the new content of your message");
        buffer = new Scanner(System.in);
        newContent = buffer.next();
        msg.setCreatedAt(date);

        msg.setContent(newContent);
        message = DAOMessageChannel.update(msg);
        System.out.println("your content has been changed successfully");
        return message;
    }


     **********************************************************/
}
