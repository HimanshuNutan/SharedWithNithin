import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Java24_VendingMachine {
    public static void main(String[] args) {
        Machine vendingMachine = new Machine();
        vendingMachine.vendingProcess();
    }
}

class Coin {
    String name;
    int value;
}

class Item {
    String name;
    int cost;
}

class Machine {
    private static final int MAX_CAPACITY = 5;
    HashMap<ITEM, Integer> items = new HashMap<>();
    HashMap<COIN, Integer> coins = new HashMap<>();
    int balance = 0;
    Scanner scanner = new Scanner(System.in);

    public Machine() {
        items.put(ITEM.COKE, 4);
        items.put(ITEM.PEPSI, 5);
        items.put(ITEM.SODA, 5);
        coins.put(COIN.PENNY, 10);
        coins.put(COIN.NICKLE, 10);
        coins.put(COIN.DIME, 10);
        coins.put(COIN.QUARTER, 10);
    }

    public void vendingProcess() {
        int user = 99, choice = 99, choice1 = 99;
        do {
            System.out.println("1. User \n2. Supplier \n0. Exit");
            user = scanner.nextInt();
            if (user == 1) {
                do {
                    System.out.println("1. Insert Coins \n2. Pick your drink \n3. Cancel request and refund" +
                            "\n4. Return an item\n5. Check your balance \n0. Exit");
                    choice1 = scanner.nextInt();
                    if (choice1 == 1) {
                        do {
                            System.out.println("Choose coin type \n1. Penny\n2. Nickel\n3. Dime\n4. Quarter\n0.Exit");
                            COIN coin;
                            choice = scanner.nextInt();
                            if (choice == 1) {
                                coin = COIN.PENNY;
                            } else if (choice == 2) {
                                coin = COIN.NICKLE;
                            } else if (choice == 3) {
                                coin = COIN.DIME;
                            } else if (choice == 4) {
                                coin = COIN.QUARTER;
                            } else {
                                if (choice != 0) System.out.println("Invalid choice");
                                break;
                            }
                            balance = balance + coin.getValue();
                            coins.put(coin, coins.get(coin) + 1);
                        } while (choice != 0);
                    } else if (choice1 == 2) {
                        boolean surity = true;
                        do {
                            ITEM pickedItem = null;
                            System.out.println("Pick your drink \n1. Coke\n2. Pepsi\n3. Soda\n0. Exit");
                            choice = scanner.nextInt();
                            if (choice == 1) {
                                pickedItem = ITEM.COKE;
                            } else if (choice == 2) {
                                pickedItem = ITEM.PEPSI;
                            } else if (choice == 3) {
                                pickedItem = ITEM.SODA;
                            } else if (choice == 0) {
                                surity = false;
                            } else {
                                System.out.println("Invalid choice");
                            }
                            if (choice == 1 || choice == 2 || choice == 3) {
                                System.out.println("Item chosen - " + pickedItem);
                                System.out.println("Are you sure? Enter 1 to confirm. Entering anything else will cancel your order.");
                                choice = scanner.nextInt();
                                if (choice == 1) {
                                    confirmOrder(pickedItem);
                                    break;
                                } else {
                                    surity = false;
                                }
                            }
                        } while (surity);
                    } else if (choice1 == 3) {
                        refund();
                    } else if (choice1 == 4) {
                        ITEM returnItem = null;
                        System.out.println("Choose Item to return\n1. Coke\n2. Pepsi\n3. Soda\n0. Exit");
                        choice = scanner.nextInt();
                        if (choice != 1 && choice != 2 && choice != 3) {
                            System.out.println("Invalid choice");
                            break;
                        }
                        if (choice == 1) {
                            returnItem = ITEM.COKE;
                        } else if (choice == 2) {
                            returnItem = ITEM.PEPSI;
                        } else if (choice == 3) {
                            returnItem = ITEM.SODA;
                        }
                        returnItem(returnItem);
                    } else if (choice1 == 5) {
                        int balance = calculateBalance();
                        System.out.println("Your balance is " + calculateBalanceString(balance));
                    }
                } while (choice1 != 0);
            } else if (user == 2) {
                System.out.println("Enter password for Supplier");
                scanner.nextLine();
                String password = scanner.nextLine();
                if (password.equals("1234")) {
                    do {
                        System.out.println("1. Refill items \n2. Check item quantity \n0. Exit");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            refill();
                        } else if (choice == 2) {
                            printItems();
                        } else {
                            if (choice != 0) System.out.println("Invalid choice");
                        }
                    } while (choice != 0);
                }
            }
        } while (user != 0);
    }

    private void returnItem(ITEM returnItem) {
        if (items.get(returnItem) == MAX_CAPACITY) {
            System.out.println("Can not be returned!");
        } else {
            items.put(returnItem, items.get(returnItem) + 1);
            balance = balance + returnItem.cost;
            System.out.println("Item returned - " + returnItem.getName());
            System.out.println(calculateBalanceString(calculateBalance()));
        }
    }

    private String calculateBalanceString(int balance) {
        int dollars = 0, cents = 0;
        String balanceString = balance + " cents";
        if (balance > 100) {
            dollars = balance / 100;
            cents = balance % 100;
            balanceString = dollars + " dollars " + cents + " cents";
        }
        return balanceString;
    }

    private void confirmOrder(ITEM item) {
        if (balance >= item.cost) {
            balance = balance - item.cost;
            System.out.println("Enjoy your " + item);
            System.out.println("Your balance is " + calculateBalanceString(calculateBalance()));
        } else {
            System.out.println("Not enough Balance! Please add money first!");
        }
    }

    private void refund() {
        System.out.println("Amount to be refunded " + calculateBalanceString(calculateBalance()));
        convertBalanceToCoins(calculateBalance());
    }

    private void convertBalanceToCoins(int calculateBalance) {
        HashMap<COIN, Integer> returnCoins = new HashMap<>();
        returnCoins.put(COIN.PENNY, 0);
        returnCoins.put(COIN.NICKLE, 0);
        returnCoins.put(COIN.DIME, 0);
        returnCoins.put(COIN.QUARTER, 0);
        while (balance >= COIN.QUARTER.getValue()) {
            if (coins.get(COIN.QUARTER) > 0) {
                returnCoins.put(COIN.QUARTER, returnCoins.get(COIN.QUARTER) + 1);
                coins.put(COIN.QUARTER, coins.get(COIN.QUARTER) - 1);
                balance = balance - COIN.QUARTER.getValue();
            } else {
                break;
            }
        }
        while (balance >= COIN.DIME.getValue()) {
            if (coins.get(COIN.DIME) > 0) {
                returnCoins.put(COIN.DIME, returnCoins.get(COIN.DIME) + 1);
                coins.put(COIN.DIME, coins.get(COIN.DIME) - 1);
                balance = balance - COIN.DIME.getValue();
            } else {
                break;
            }
        }
        while (balance >= COIN.NICKLE.getValue()) {
            if (coins.get(COIN.NICKLE) > 0) {
                returnCoins.put(COIN.NICKLE, returnCoins.get(COIN.NICKLE) + 1);
                coins.put(COIN.NICKLE, coins.get(COIN.NICKLE) - 1);
                balance = balance - COIN.NICKLE.getValue();
            } else {
                break;
            }
        }
        while (balance >= COIN.PENNY.getValue()) {
            if (coins.get(COIN.PENNY) > 0) {
                returnCoins.put(COIN.PENNY, returnCoins.get(COIN.PENNY) + 1);
                coins.put(COIN.PENNY, coins.get(COIN.PENNY) - 1);
                balance = balance - COIN.PENNY.getValue();
            } else {
                break;
            }
        }
        System.out.println("Remaining Balance = " + calculateBalance());
        System.out.println(returnCoins.toString());
    }

    private void printItems() {
        System.out.println(items.toString());
    }

    private int calculateBalance() {
        return balance;
    }

    private void refill() {
        int choice = 99;
        do {
            System.out.println("Choose the item to refill \n " +
                    "1. COKE \n2. PEPSI\n3. SODA \n0. Exit");
            choice = scanner.nextInt();
            ITEM item;
            if (choice == 1) {
                item = ITEM.COKE;
            } else if (choice == 2) {
                item = ITEM.PEPSI;
            } else if (choice == 3) {
                item = ITEM.SODA;
            } else {
                if (choice != 0) System.out.println("Invalid choice");
                break;
            }
            int capacity = items.get(item);
            if (capacity == MAX_CAPACITY) {
                System.out.println("Item already up to full capacity");
            } else {
                items.put(item, 5);
                System.out.println("Filled " + item + " to max capacity = " + MAX_CAPACITY);
            }

        } while (choice != 0);
    }
}

enum ITEM {
    COKE("coke", 25), PEPSI("pepsi", 35), SODA("soda", 45);
    String name;
    int cost;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    ITEM(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

enum COIN {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    int value;

    public int getValue() {
        return value;
    }

    COIN(int value) {
        this.value = value;
    }
}
