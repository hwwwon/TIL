#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b, int n) {
    int num = 0;
    while(true){
        if(n < a) break;
        int mart = n - (n%a);
        int co = (mart / a) * b;
        num += co;
        n = co + (n%a);
    }
    return num;
}   
    