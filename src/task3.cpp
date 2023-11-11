#include <iostream>
#include <vector>

// Function to rearrange soldiers
void rearrangeSoldiers(std::vector<std::string>& soldiers) {
    int n = soldiers.size();
    for (int i = 0; i < n - 1; i += 2) {
        std::swap(soldiers[i], soldiers[i + 1]);
    }
}

int main() {
    std::vector<std::string> soldiers = {"Alpha", "Bravo", "Charlie", "Delta", "Echo"};

    // Rearrange the soldiers
    rearrangeSoldiers(soldiers);

    // Display the rearranged soldier lineup
    for (const auto& soldier : soldiers) {
        std::cout << soldier << std::endl;
    }

    return 0;
}