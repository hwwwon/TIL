WITH RECURSIVE H AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM H
    WHERE HOUR < 23
)
SELECT H.HOUR, COUNT(HOUR(O.DATETIME)) AS COUNT
FROM H
LEFT JOIN ANIMAL_OUTS O ON H.HOUR = HOUR(O.DATETIME)
GROUP BY H.HOUR
ORDER BY 1 ASC;
