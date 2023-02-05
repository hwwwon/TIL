SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(REVIEW_SCORE),2) AS SCORE
FROM REST_INFO I
LEFT JOIN REST_REVIEW R ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY REST_ID
HAVING SCORE IS NOT NULL
ORDER BY SCORE DESC, FAVORITES DESC;