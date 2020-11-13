class HolidayBonus{
  public static double[][] calculateHolidayBonus(double[][] data, double high, double low, double other){
    double[][] bonus = new double[data.length][data[0].length];
    for (int j = 0; j < data[0].length; j++) {
      int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
      int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
      for (int i = 0; i < data.length; i++) {
        if (i == highestIndex)
          bonus[i][j] = high;
        else if (i == lowestIndex)
          bonus[i][j] = low;
        else
          bonus[i][j] = other;
        if (data[i][j] < 0)
          bonus[i][j] = 0;
      }
    }
    return bonus;
  }
  public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other){
    double[][] bonus = calculateHolidayBonus(data, high, low, other);
    double total = TwoDimRaggedArrayUtility.getTotal(bonus);
    return total;
  }
}
