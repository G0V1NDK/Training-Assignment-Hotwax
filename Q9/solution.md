### QUESTION

Find all the orders whose two or more items are canceled but the orders are still in the approved status.

### SOLUTION:

```sql
SELECT
    oh.ORDER_ID,
    COUNT(DISTINCT oi.ORDER_ITEM_SEQ_ID) AS CANCELLED_ITEMS
FROM order_header oh
JOIN  order_item oi ON oi.ORDER_ID = oh.ORDER_ID AND oi.STATUS_ID = 'ITEM_CANCELLED'
WHERE oh.STATUS_ID = 'ORDER_APPROVED'
GROUP BY oh.ORDER_ID
HAVING CANCELLED_ITEMS > 1;

```

![Alt text](image.png)