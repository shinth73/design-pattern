#include <stdio.h>
#include <stdlib.h>
#include "array.h"

void arInit(Array* a, int size) {
  a->data = malloc(sizeof(void*) * size);
  a->count = 0;
  a->size = size;
}

void arClose(Array* a) {
  free(a->data);
}

void arSetSize(Array* a, int size) {
  int newsize = max(size, 2);
  a->data = (void**)realloc( a->data, sizeof(void*) * size);
  a->size = newsize;
  if (a->count > a->size) a->count = a->size;
}

void arAdd(Array* a, void* value) {
  if (a->count >= a->size) 
    arSetSize(a, a->size * 2);
  a->data[a->count] = value;
  ++a->count;
}

void arInsertAt(Array* a, int index, void* value) {
  int i;
  if (a->count >= a->size) arSetSize(a, a->size * 2);
  for (i = a->count-1; i >= index; --i)
    a->data[i+1] = a->data[i];
  a->data[index] = value;
  ++a->count;
}

void arRemoveAt(Array* a, int index) {
  int i;
  for (i = index+1; i <= a->count - 1; ++i)
    a->data[i-1] = a->data[i];
  --a->count;
}

int arFind(Array *a, void* value, CompareFunc *cmp) {
  int i;
  for (i=0; i < a->count; ++i)
    if (cmp(a->data[i], value) == 0) return i;
  return -1;
}

void arDoForEach(Array *a, ActionFunc *action, void *param) {
  int i;
  for (i=0; i < a->count; ++i)
    action(a->data[i], param);
}

static int binarySearch(Array* a, void* data, CompareFunc *cmp) {
  int bottom, top;
  bottom = 0;
  top = a->count - 1;
  while (bottom <= top)
  {
    int i, t;
    i = (top + bottom) / 2;
    t = cmp(a->data[i],data);
    if (t == 0) return i;
    if (t < 0) 
      bottom = i + 1;
    else
      top = i - 1;
  }
  return bottom;
}

int arBinarySearch(Array* a, void* data, CompareFunc *compareFunc) {
  int i;
  
  if (a->count == 0) return -1;
  i = arBinarySearch(a, data, compareFunc);
  if (i >= a->count) return -1;
  if (compareFunc(a->data[i], data) == 0) 
    return i;
  return -1;
}

void arQuicksort(Array* a, int lo, int hi, CompareFunc *cmp) {
  int i=lo, j=hi;
  void *h, *x = a->data[(lo+hi)/2];

  do {
    while (cmp(a->data[i], x) < 0) i++; 
    while (cmp(a->data[j], x) > 0) j--;
    if (i<=j) {
      h=a->data[i]; a->data[i]=a->data[j]; a->data[j]=h;
      i++; j--;
    }
  } while (i<=j);

  if (lo<j) arQuicksort(a, lo, j, cmp);
  if (i<hi) arQuicksort(a, i, hi, cmp);
}

void arSort(Array* a, CompareFunc *cmp) {
  arQuicksort(a, 0, a->count-1, cmp);
}
