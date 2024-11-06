package macropass2;

public class arglist {
    String argname;
    String value;

    // Constructor that accepts both argname and value
    arglist(String argument, String value) {
        this.argname = argument;
        this.value = value;
    }

    // Constructor that only accepts argname and sets a default value for value
    arglist(String argument) {
        this.argname = argument;
        this.value = ""; // Default value for cases when value is not provided
    }
}
