### Question
8. How many orders with a single return were recorded in the last month?

### Solution

```sql

SELECT 
    COUNT(*)
FROM
    (SELECT 
        ri.ORDER_ID, COUNT(DISTINCT ri.RETURN_ID) AS TOTAL_RETURNS
    FROM
        return_header rh
    JOIN return_item ri ON ri.RETURN_ID = rh.RETURN_ID
    WHERE
        rh.entry_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
            AND ri.ORDER_ID IS NOT NULL
    GROUP BY ri.ORDER_ID
    HAVING TOTAL_RETURNS = 1) AS TOTAL_ORDERS;

```
![image](https://github.com/G0V1NDK/Training-Assignment-Hotwax/assets/83280091/2e7ca8d2-76fb-4840-bbd8-31cc70a2e7c4)
