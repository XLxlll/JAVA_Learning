package com.company.thread_learning;

/**
 * CAS Compare And Set
 *  要改的值， V
 *  期望当前的值，E，拿到旧V的值
 *  新的值，N
 *  if V == E
 *      V = N
 *      otherwise try again or fail
 *  CAS是CPU原语支持，中间不允许打断，也就是说不存在比较V E的时候，V E的值发生改变
 *  ABA问题-解决
 *  -int等基础类型的没有关系，若是一个Object类型（引用）会出现问题
 *  -需要加版本号，cas检查的时候需要加版本号检测AtomicStampedReference解决ABA
 */
public class CASLearning {
}
