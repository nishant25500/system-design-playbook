package Splitwise.entity;

import java.sql.Timestamp;

public class Balance {
    int id;

    int borrowerId;

    int paidById;

    double outstanding;

    Timestamp cretadAt;

    Timestamp updatedAt;
}
