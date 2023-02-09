SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) AS TOTAL_SALES
FROM AUTHOR A
INNER JOIN BOOK B ON A.AUTHOR_ID = B.AUTHOR_ID
INNER JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID 
WHERE S.SALES_DATE LIKE '2022-01%'
GROUP BY 1,3
ORDER BY 1 ASC, 3 DESC;