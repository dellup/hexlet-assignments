package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    String str;

    public NegativeRadiusException(String str) {
        this.str = str;
    }

    public NegativeRadiusException() {

    }
}
// END
