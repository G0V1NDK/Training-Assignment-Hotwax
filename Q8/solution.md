### QUESTION

Find all the orders whose two or more items are completed but the orders are still in the approved status.

### SOLUTION:

```sql
SELECT
    oi.ORDER_ID,
    COUNT(DISTINCT oi.ORDER_ITEM_SEQ_ID) AS COMPLETED_ITEMS
FROM Order_Header oh
JOIN  Order_Item oi ON oi.ORDER_ID = oh.ORDER_ID
JOIN Order_Status os ON oi.ORDER_ID = os.ORDER_ID
WHERE oh.STATUS_ID = 'ORDER_APPROVED' AND oi.STATUS_ID = 'ITEM_COMPLETED' 
GROUP BY oi.ORDER_ID
HAVING COMPLETED_ITEMS > 1;


```

![Alt text](image.png)