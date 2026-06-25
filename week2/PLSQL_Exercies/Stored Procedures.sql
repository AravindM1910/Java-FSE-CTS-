CREATE TABLE BankAccounts (
    AccId NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(30),
    Balance NUMBER(12,2),
    AccType VARCHAR2(20)
);

CREATE TABLE Staff (
    EmpId NUMBER PRIMARY KEY,
    EmpName VARCHAR2(30),
    Salary NUMBER(12,2),
    DeptId NUMBER
);

CREATE OR REPLACE PROCEDURE AddInterest AS
BEGIN
    UPDATE BankAccounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccType = 'Savings';
END;
/

CREATE OR REPLACE PROCEDURE GiveBonus(
    deptNo IN NUMBER,
    bonus IN NUMBER
) AS
BEGIN
    UPDATE Staff
    SET Salary = Salary + (Salary * bonus / 100)
    WHERE DeptId = deptNo;
END;
/

CREATE OR REPLACE PROCEDURE TransferMoney(
    sourceAcc IN NUMBER,
    targetAcc IN NUMBER,
    amount IN NUMBER
) AS
    currentBalance NUMBER;
BEGIN
    SELECT Balance
    INTO currentBalance
    FROM BankAccounts
    WHERE AccId = sourceAcc;

    IF currentBalance >= amount THEN

        UPDATE BankAccounts
        SET Balance = Balance - amount
        WHERE AccId = sourceAcc;

        UPDATE BankAccounts
        SET Balance = Balance + amount
        WHERE AccId = targetAcc;

    ELSE
        RAISE_APPLICATION_ERROR(-20001,'Not enough balance');
    END IF;
END;
/