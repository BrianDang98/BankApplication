package bankapplication;

import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BankApplication extends Application implements EventHandler<ActionEvent> {

    private Scene home, addScene, depositScene, withdrawScene, listScene, transferScene;
    Stage window;  // represents main Stage globally
    Button btnAddMenu, btnDepositMenu, btnWithdrawMenu, btnTransferMenu, btnListMenu, btnAdd, btnHome, btnListHome, btnDeposit, btnDepositHome, btnWithdraw, btnWithdrawHome, btnTransfer, btnTransferHome;
    TextField custName, custAccNum, custDepositAccNum, custWithdrawAccNum, custBalance, depositAmount, withdrawAmount, fromAccNum, toAccNum, transferAmount;
    TextArea accountList;
    Bank bank;

    public void init() {
        bank = new Bank(10000);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        // setting up Home Scene
        Label lblHomeMenu = new Label("Welcome to Trusty Bank. Please select an option from below");
        btnAddMenu = new Button("Add");
        btnAddMenu.setOnAction(this);
        btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        btnDepositMenu = new Button("Deposit");
        btnDepositMenu.setOnAction(this);
        btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        btnWithdrawMenu = new Button("Withdraw");
        btnWithdrawMenu.setOnAction(this);
        btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        btnTransferMenu = new Button("Transfer");
        btnTransferMenu.setOnAction(this);
        btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        btnListMenu = new Button("List");
        btnListMenu.setOnAction(this);
        btnListMenu.setMaxWidth(Double.MAX_VALUE);
        VBox homeLayout = new VBox();
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.getChildren().addAll(lblHomeMenu, btnAddMenu, btnDepositMenu, btnWithdrawMenu, btnTransferMenu, btnListMenu);
        home = new Scene(homeLayout, 600, 600);

        // setting up Add Scene
        Label lblName = new Label("Name:");
        custName = new TextField();
        Label lblAccNum = new Label("Account#:");
        custAccNum = new TextField();
        Label lblBalance = new Label("Balance:");
        custBalance = new TextField();
        btnAdd = new Button("Add Account");
        btnAdd.setOnAction(this);
        btnHome = new Button("Back");
        btnHome.setOnAction(this);
        VBox addLayout = new VBox();
        addLayout.getChildren().addAll(lblName, custName, lblAccNum, custAccNum, lblBalance, custBalance, btnAdd, btnHome);
        addScene = new Scene(addLayout, 600, 600);

        // setting up Deposit Scene
        Label lblDepositAccNum = new Label("Account#:");
        custDepositAccNum = new TextField();
        Label lblDepositAmount = new Label("Deposit Amount:");
        depositAmount = new TextField();
        btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(this);
        btnDepositHome = new Button("Back");
        btnDepositHome.setOnAction(this);
        VBox depositLayout = new VBox();
        depositLayout.getChildren().addAll(lblDepositAccNum, custDepositAccNum, lblDepositAmount, depositAmount, btnDeposit, btnDepositHome);
        depositScene = new Scene(depositLayout, 600, 600);

        // setting up Withdraw Scene
        Label lblWithdrawAccNum = new Label("Account#:");
        custWithdrawAccNum = new TextField();
        Label lblWithdrawAmount = new Label("Withdraw Amount:");
        withdrawAmount = new TextField();
        btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(this);
        btnWithdrawHome = new Button("Back");
        btnWithdrawHome.setOnAction(this);
        VBox withdrawLayout = new VBox();
        withdrawLayout.getChildren().addAll(lblWithdrawAccNum, custWithdrawAccNum, lblWithdrawAmount, withdrawAmount, btnWithdraw, btnWithdrawHome);
        withdrawScene = new Scene(withdrawLayout, 600, 600);

        // setting up Transfer Scene
        Label lblFromAccount = new Label("From Account#:");
        fromAccNum = new TextField();
        Label lblToAccount = new Label("To Account#:");
        toAccNum = new TextField();
        Label lblTransferAmount = new Label("Transfer Amount:");
        transferAmount = new TextField();
        btnTransfer = new Button("Transfer");
        btnTransfer.setOnAction(this);
        btnTransferHome = new Button("Back");
        btnTransferHome.setOnAction(this);
        VBox transferLayout = new VBox();
        transferLayout.getChildren().addAll(lblFromAccount, fromAccNum, lblToAccount, toAccNum, lblTransferAmount, transferAmount, btnTransfer, btnTransferHome);
        transferScene = new Scene(transferLayout, 600, 600);

        // setting up List Scene
        Label lblShow = new Label("List of accounts...");
        accountList = new TextArea();
        btnListHome = new Button("Back");
        btnListHome.setOnAction(this);
        btnListHome.setMaxWidth(Double.MAX_VALUE);
        VBox listLayout = new VBox();
        listLayout.getChildren().addAll(lblShow, accountList, btnListHome);
        listScene = new Scene(listLayout, 600, 600);
        

        window.setScene(home);
        window.show();
    }

    public void stop() {

    }

    // function alert account successfull added
    public void addAccountSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONGRATULATION");
        alert.setHeaderText(null);
        alert.setContentText("Account Added Successfully...");
        alert.showAndWait();
    }

    // function alert deposit successfully
    public void depositSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONGRATULATION");
        alert.setHeaderText(null);
        alert.setContentText("Deposit Successfully...");
        alert.showAndWait();
    }

    // function alert withdraw successfully
    public void withdrawSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONGRATULATION");
        alert.setHeaderText(null);
        alert.setContentText("Withdraw Successfully...");
        alert.showAndWait();
    }

    // function alert transfer successfully
    public void transferSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONGRATULATION");
        alert.setHeaderText(null);
        alert.setContentText("Transfer Successfully...");
        alert.showAndWait();
    }

    // function alert wrong input warning
    public void inputsWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Wrong Inputs Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please enter valid inputs");
        alert.showAndWait();
    }
    //fuction clear TextField
    public void clearText(){
        custName.setText("");
        custAccNum.setText("");
        custDepositAccNum.setText("");
        custWithdrawAccNum.setText("");
        custBalance.setText("");
        depositAmount.setText("");
        withdrawAmount.setText("");
        fromAccNum.setText("");
        toAccNum.setText("");
        transferAmount.setText("");
    }

    public void handle(ActionEvent e) {

        if (e.getSource() == btnAddMenu) {
            System.out.println("add Menu btn pressed (on menu scene)");
            window.setScene(addScene);

        }

        if (e.getSource() == btnAdd) {
            try {
                long accNum = Long.valueOf(custAccNum.getText());
                double bal = Double.valueOf(custBalance.getText());
                String own = String.valueOf(custName.getText());
                bank.addAccount(accNum, bal, own);
                clearText();
                // Using Alert to show message
                addAccountSuccess();

            } catch (Exception ex) {
                // Using Alert to show warning message
                inputsWarning();

            }

        }

        if (e.getSource() == btnDepositMenu) {
            System.out.println("deposit Menu btn pressed (on menu scene)");
            window.setScene(depositScene);
        }

        if (e.getSource() == btnDeposit) {
            try {

                long accNum = Long.valueOf(custDepositAccNum.getText());
                double amount = Double.valueOf(depositAmount.getText());
                bank.depositAccount(accNum, amount);
                clearText();
                depositSuccess();

            } catch (Exception ex) {
                inputsWarning();
            }

        }

        if (e.getSource() == btnWithdrawMenu) {
            System.out.println("withdraw Menu btn pressed (on menu scene)");
            window.setScene(withdrawScene);

        }
        if (e.getSource() == btnWithdraw) {
            try {
                if (Double.valueOf(custBalance.getText()) <= 0 || Double.valueOf(custBalance.getText()) < Double.valueOf(withdrawAmount.getText())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Balance");
                    alert.setHeaderText(null);
                    alert.setContentText("Not sufficient balance to withdraw");
                    alert.showAndWait();
                } else {
                    long accNum = Long.valueOf(custWithdrawAccNum.getText());
                    double amount = Double.valueOf(withdrawAmount.getText());
                    bank.withdrawAccount(accNum, amount);
                    clearText();
                    withdrawSuccess();
                }

            } catch (Exception ex) {
                inputsWarning();
            }

        }

        if (e.getSource() == btnTransferMenu) {
            System.out.println("transfer Menu btn pressed (on menu scene)");
            window.setScene(transferScene);

        }
        if (e.getSource() == btnTransfer) {
            try {
                if (Double.valueOf(custBalance.getText()) <= 0 || Double.valueOf(custBalance.getText()) < Double.valueOf(withdrawAmount.getText())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Balance");
                    alert.setHeaderText(null);
                    alert.setContentText("Not sufficient balance to trasnfer");
                    alert.showAndWait();
                } else {
                    long accountFrom = Long.valueOf(fromAccNum.getText());
                    long accountTo = Long.valueOf(toAccNum.getText());
                    double amount = Double.valueOf(transferAmount.getText());
                    bank.transfer(accountFrom, accountTo, amount);
                    clearText();
                    transferSuccess();
                }

            } catch (Exception ex) {
                inputsWarning();
            }

        }

        if (e.getSource() == btnListMenu) {
            System.out.println("list accounts btn pressed (on menu scene)");
            accountList.setText(bank.printAccounts());
            window.setScene(listScene);

        }
        if (e.getSource() == btnHome || e.getSource() == btnListHome || e.getSource() == btnDepositHome || e.getSource() == btnWithdrawHome || e.getSource() == btnTransferHome) {
            System.out.println("Back btn pressed (on add scene or list scene or deposit scene or withdraw scene or transfer scene)");
            clearText();
            window.setScene(home);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
