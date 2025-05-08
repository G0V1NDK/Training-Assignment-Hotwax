### Question
7. On a city-wise basis, what is the analysis of returns? 


### Solution

```sql

SELECT pa.CITY, COUNT(DISTINCT rh.RETURN_ID) AS RETURN_ORDERS, COUNT(DISTINCT ri.RETURN_ITEM_SEQ_ID) AS RETURN_ITEMS, 
COUNT(rs.STATUS_ID) AS RETURN_COMPLETED_COUNT FROM return_header rh
JOIN return_contact_mech rcm ON rh.RETURN_ID = rcm.RETURN_ID
JOIN postal_address pa ON rcm.CONTACT_MECH_ID = pa.CONTACT_MECH_ID
JOIN return_item ri ON rh.RETURN_ID = ri.RETURN_ID
JOIN return_status rs ON rs.RETURN_ID = ri.RETURN_ID AND ri.RETURN_ITEM_SEQ_ID = rs.RETURN_ITEM_SEQ_ID AND rs.STATUS_ID = "RETURN_COMPLETED"
GROUP BY pa.CITY;

```
![Alt text](https://github.com/G0V1NDK/Training-Assignment-Hotwax/blob/SQL-Assignment-3/Q7/image-1.png)
![Alt text](image.png)
