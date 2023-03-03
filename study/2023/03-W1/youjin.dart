class Solution {
  List<int> dailyTemperatures(List<int> temperatures) {
    if (temperatures.isEmpty) {
      return [0];
    }

    int length = temperatures.length;

    List<int> result = List.filled(temperatures.length, 0);

    List<int> stack = [];

    for (int j = length - 1; j >= 0; j--) {
      while (stack.isNotEmpty && temperatures[stack.last] <= temperatures[j])
        stack.removeLast();
      result[j] = stack.isEmpty ? 0 : stack.last - j;
      stack.add(j);
    }
    return result;
  }
}
  
