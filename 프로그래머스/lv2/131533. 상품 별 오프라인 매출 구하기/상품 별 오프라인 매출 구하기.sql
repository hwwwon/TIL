-- 코드를 입력하세요
SELECT PRODUCT_CODE, PRICE * SUM(SALES_AMOUNT) AS SALES FROM PRODUCT P ,OFFLINE_SALE O
WHERE P.PRODUCT_ID = O.PRODUCT_ID GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE