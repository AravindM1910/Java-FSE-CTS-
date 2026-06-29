CREATE TABLE customers(
    customerID NUMBER PRIMARY KEY,
    cname VARCHAR2(30),
    age NUMBER,
    balance NUMBER,
    interest NUMBER,
    vip VARCHAR2(5)
);

INSERT INTO customers VALUES (101,'Ram',65,10000,5.5,'No');
INSERT INTO customers VALUES (102,'Rahul',45,15000,6.0,'No');
INSERT INTO customers VALUES (103,'Varma',70,20000,5.0,'Yes');

-- Scenario 1: Reduce interest for senior citizens
BEGIN
    FOR rec IN (SELECT customerID FROM customers WHERE age > 60)
    LOOP
        UPDATE customers
        SET interest = interest - 1
        WHERE customerID = rec.customerID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Mark VIP customers
BEGIN
    FOR rec IN (SELECT customerID FROM customers WHERE balance > 10000)
    LOOP
        UPDATE customers
        SET vip = 'true'
        WHERE customerID = rec.customerID;
    END LOOP;
    COMMIT;
END;
/

CREATE TABLE loans(
    loanid NUMBER PRIMARY KEY,
    customerid NUMBER REFERENCES customers(customerid),
    duedate DATE
);

INSERT INTO loans VALUES (1,101,SYSDATE+10);
INSERT INTO loans VALUES (2,102,SYSDATE+35);
INSERT INTO loans VALUES (3,103,SYSDATE+10);

SET SERVEROUTPUT ON;

-- Scenario 3: Loan reminders
BEGIN
    FOR rec IN (
        SELECT loanid, customerid, duedate
        FROM loans
        WHERE duedate <= SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ' || rec.loanid ||
            ' for Customer ' || rec.customerid ||
            ' is due on ' || TO_CHAR(rec.duedate,'DD-MM-YYYY')
        );
    END LOOP;
END;
/