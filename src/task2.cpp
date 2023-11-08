#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n;
  cin >> n;

  vector<int> train(n);
  for (int i = 0; i < n; i++) {
    cin >> train[i];
  }

  vector<int> deadEnd;
  vector<int> track2;

  // Bring all cars to the dead end
  for (int i = 0; i < n; i++) {
    deadEnd.push_back(train[i]);
  }

  // Take cars from the dead end to track 2 in order
  for (int i = 0; i < n; i++) {
    while (deadEnd[0] != train[i]) {
      // Move the first car from the dead end to track 2
      int firstCar = deadEnd[0];
      deadEnd.erase(deadEnd.begin());
      track2.push_back(firstCar);

      // Move the car at the front of the train to the dead end
      int trainFrontCar = train[i];
      train.erase(train.begin());
      deadEnd.push_back(trainFrontCar);
    }

    // Move the car from the dead end to track 2
    int car = deadEnd[0];
    deadEnd.erase(deadEnd.begin());
    track2.push_back(car);
  }

  // Print the actions
  for (int i = 0; i < deadEnd.size(); i++) {
    cout << 1 << " " << deadEnd.size() - i << endl;
  }
  for (int i = 0; i < track2.size(); i++) {
    cout << 2 << " " << 1 << endl;
  }

  return 0;
}
