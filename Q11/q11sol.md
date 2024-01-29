### QUESTION

Fetch all the customers created in June 2023.

### SOLUTION:

```
SELECT
    p.PARTY_ID,
    pr.ROLE_TYPE_ID,
    p.CREATED_DATE
FROM party p
JOIN party_role pr ON p.PARTY_ID = pr.PARTY_ID 
WHERE pr.ROLE_TYPE_ID = 'CUSTOMER' AND p.CREATED_DATE BETWEEN '2023-06-01' AND '2023-06-30' and p.STATUS_ID = "PARTY_ENABLED";

```

![Alt text](image.png)