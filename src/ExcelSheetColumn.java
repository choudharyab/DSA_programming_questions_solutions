public class ExcelSheetColumn {
    public  static String convertToTitle(int columnNumber){
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char)('A' + (columnNumber % 26));

    }
    public static void main(String[] args) {
        int columnNumber = 1;
        String ans = convertToTitle(columnNumber);
        System.out.println("ans---> "+ ans);
    }
}
