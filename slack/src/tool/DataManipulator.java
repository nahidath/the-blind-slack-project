package tool;

public class DataManipulator {

    /**
     *
     */
    private DataManipulator(){}

    /**
     * @param email
     * @return true if the email is valid, false if not
     */
    public static boolean isValidEmailAddress(String email){
        // using regex pattern and matchers to verify the email address
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Method to check if password is valid or not.
     * @param password
     * @return boolean
     */
    public static boolean isValidPassword(String password) {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8) {
            System.out.println("Password must be less than 20 and more than 8 characters in length.");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            System.out.println("Password must have atleast one uppercase character");
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            System.out.println("Password must have atleast one lowercase character");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            System.out.println("Password must have atleast one number");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars)) {
            System.out.println("Password must have atleast one special character among @#$%");
            isValid = false;
        }
        return isValid;
    }

}
