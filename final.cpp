/*
Programmer: Adam Hill
Date: 10/04/17
Chapter: 3
Exercise: 5
Purpose: take the indata and output it with updated salary and in first last name, updated salary format.
*/

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <cmath>
#include <cctype>
using namespace std;

int main()
{
	//declare the variables
	string item;
	int quantity, quantityCounter=0, recordCounter=0;
	double boughtPrice, sellingPrice, profit;
	double totalBought=0, totalSelling=0, totalProfit=0;
	double averageQuantity, averageProfit;
	ofstream outFile;

	//open the outfile
	outFile.open("Profit_Report.txt");

	outFile << fixed << showpoint << setprecision(2);

	// print the report title and column headings
	outFile << "                                    Estimated Profit Report\n\n";
	outFile << "Item                 Quantity         Bought Price($)     Selling Price($)        Profit($)\n";
	outFile << "--------------------------------------------------------------------------------------------\n";
	
	//get the input to start loop
	cout << "Please enter the quantity of the item or type 0 to end loop: ";
	cin >> quantity;
	while (quantity < 0)	
	{
		cout << "Value must be positive." << endl;
		cout << "Please enter the quantity of the item or type 0 to end loop: ";
		cin >> quantity;
	}

	//sentinel loop
	while (quantity !=0)
	{
		// get the other inputs and validate them
		cin.ignore(100, '\n');
		cout << "Please enter the item name: ";
		getline(cin, item);

		cout << "Please enter the bought price of the item: ";
		cin >> boughtPrice;
		while (boughtPrice < 0)
		{
			cout << "Value must be positive." << endl;
			cout << "Please enter the bought price of the item: ";
			cin >> boughtPrice;
		}



		cout << "Please enter the selling price of the item: ";
		cin >> sellingPrice;

		while (sellingPrice < 0)
		{
			cout << "Value must be positive." << endl;
			cout << "Please enter the selling price of the item: ";
			cin >> sellingPrice;
		}

		
		//calculations and counters
		profit = (sellingPrice*quantity) - (boughtPrice*quantity);
		totalBought += (boughtPrice*quantity);
		totalProfit += (profit);
		totalSelling += (sellingPrice*quantity);
		quantityCounter += quantity;
		recordCounter++;

		// write to output file for the data
		outFile << left << setw(21) << item;
		outFile <<   right << " " << setprecision(2) << setw(7) << quantity << " ";
		outFile  << setprecision(2) << setw(23) << boughtPrice << " ";
		outFile << "        " <<  setw(12) << sellingPrice << " ";
		outFile << "    " << setw(12) << profit << endl;

		cout << "Please enter the quantity of the item or type 0 to end loop: ";
		cin >> quantity;


		while (quantity < 0)	//validation loop
		{
			cout << "Value must be positive." << endl;
			cout << "Please enter the quantity of the item or type 0 to end loop: ";
			cin >> quantity;
		}

	}
	//more calculations
	averageProfit = totalProfit / recordCounter;

	// when no data is entered makes sure average is 0 and not an error
	if (quantityCounter == 0)
	{
		averageProfit = 0;
	}
	//outfile for totals and averages
	outFile << "--------------------------------------------------------------------------------------------\n";
	outFile << left << setw(10) << "Total";
	outFile << right <<" " << setprecision(2) << setw(18) << quantityCounter;
	outFile  << setw(24) << totalBought;
	outFile <<  setw(21) << totalSelling ;
	outFile <<  setw(17) << totalProfit << endl;

	outFile << left << setw(18) << "Average";
	outFile << right << "  " << setprecision(2)  << setw(71) << averageProfit;

	//record counter and states who created report
	outFile << "\n\n" << left << recordCounter << " items were processed." << endl;
	outFile <<  left << "Report created by Adam Hill." << endl;
	//close outfile
	outFile.close();

	system("pause");
	return 0;
}