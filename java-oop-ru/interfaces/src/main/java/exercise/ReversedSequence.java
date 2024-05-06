package exercise;

// BEGIN

public class ReversedSequence implements CharSequence {

    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }
}

// END
