#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "array.h"

int compareInteger( void* i1, void* i2) {
  return (int)i1 - (int)i2;
}

int compareString( void* s1, void* s2) {
  return strcmp(s1, s2);
}

void printInteger(void* p, void* param) {
  printf("%d ", p);
}

void printString(void* p, void* param) {
  printf("%s ", p);
}

void main() {
  Array a1, a2;
  int i;
  char s[100];

  arInit(&a1, 10);
  for (i = 0; i < 20; ++i) 
      arAdd(&a1, (void*)(rand() % 100));

  printf("sorting integer: ");
  arSort(&a1, compareInteger);
  arDoForEach(&a1, printInteger, NULL);
  printf("\n");

  arInit(&a2, 10);
  for (i = 0; i < 20; ++i) {
      sprintf(s, "%d", rand() % 100);
      arAdd(&a2, strdup(s));
  }

  printf("sorting string: ");
  arSort(&a2, compareString);
  arDoForEach(&a2, printString, NULL);
  printf("\n");
}