### Question
Fetch the order id and contact mech id for the shipping address of the orders completed in October of 2023.

### SOLUTION:

```sql
SELECT oh.order_id, ocm.contact_mech_id 
FROM order_header oh 
JOIN order_contact_mech ocm ON oh.order_id = ocm.order_id
JOIN order_status os ON os.order_id = oh.order_id 
WHERE os.status_id = 'ORDER_COMPLETED' AND ocm.contact_mech_purpose_type_id = 'SHIPPING_LOCATION' 
AND EXTRACT(YEAR FROM os.status_datetime) = '2023' 
AND EXTRACT(MONTH FROM os.status_datetime) = '10';
```

![Alt text](image.png)