package Splitwise.entity;

import java.sql.Timestamp;

public class Expense {
    int id;

    int paidById;

    double amount;

    int groupId;

    String description;

    Timestamp createdAt;
}
