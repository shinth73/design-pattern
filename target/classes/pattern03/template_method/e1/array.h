#ifndef ARRAY_H
#define ARRAY_H

typedef struct array {
  void** data;
  int count;
  int size;
} Array;

typedef int CompareFunc(void* value1, void* value2);
typedef void ActionFunc(void* value, void* param);
void arInit(Array* a, int size);
void arClose(Array* a);
void arSetSize(Array* a, int size);
void arAdd(Array* a, void* value);
void arInsertAt(Array* a, int index, void* value);
void arRemoveAt(Array* a, int index);
int  arFind(Array *a, void* value, CompareFunc *cmp);
void arDoForEach(Array *a, ActionFunc *action, void *param);
int  arBinarySearch(Array* a, void* data, CompareFunc *cmp);
void arSort(Array* a, CompareFunc *cmp);

#endif
