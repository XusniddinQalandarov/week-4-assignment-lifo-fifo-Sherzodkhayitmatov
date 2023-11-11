#include <iostream>
using namespace std;

int countElementsWithSmallerNeighbors(int arr[], int size) {
    int count = 0;
    
    for (int i = 1; i < size - 1; i++) {
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            count++;
        }
    }
    
    return count;
}

int main() {
    int arr[] = {5, 2, 8, 1, 4, 6};
    int size = sizeof(arr) / sizeof(arr[0]);
    
    int count = countElementsWithSmallerNeighbors(arr, size);
    cout << "Count of elements where both adjacent neighbors're smaller: " << count << endl;
    
    return 0;
}