-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE (MONTH(START_DATE) BETWEEN '8' AND '10') AND 
      CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
           WHERE MONTH(START_DATE) BETWEEN '8' AND '10'
           GROUP BY CAR_ID
           HAVING COUNT(*)>=5)
GROUP BY 1, 2
ORDER BY 1 ASC, 2 DESC;