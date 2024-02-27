### Question
5. In New York, which product has the highest sales?


### Solution

```sql

SELECT  oi.PRODUCT_ID, 
  p.PRODUCT_TYPE_ID, 
  p.PRODUCT_NAME, 
  p.BRAND_NAME, 
  sum(oi.QUANTITY) AS TOTAL_AMOUNT FROM order_item oi
JOIN order_contact_mech ocm ON oi.ORDER_ID = ocm.ORDER_ID
JOIN postal_address pa ON ocm.CONTACT_MECH_ID = pa.CONTACT_MECH_ID
JOIN product p ON oi.PRODUCT_ID = p.PRODUCT_ID
WHERE oi.STATUS_ID = 'ITEM_COMPLETED' AND pa.CITY = 'New York'
GROUP BY oi.PRODUCT_ID
ORDER BY TOTAL_AMOUNT DESC
LIMIT 1;

```
![Alt text](image.png)

![Alt text](image-1.png)