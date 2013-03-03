/* Преобразование сроки в числовой тип */
#include <cstdlib>
int num = strtol(str, 0, 0); // Преобразование строки в целое длинное число
double num = strtod(...); // Преобразование строки в число double
unsigned num = strtoul(...); // Преобразование строки в число unsigned long

/* Преобразование чисел в строки */
#include <sstream>
stringstream result;
result << number;
result.str();

/* Проверка, содержит ли строка допустимое число */
