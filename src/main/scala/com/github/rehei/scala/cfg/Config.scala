package com.github.rehei.scala.cfg

class Config[T](decorator: Option[T]) {
  
  def require[B](f: T => B) = {
    optional(f).getOrElse(throw new RuntimeException("Value is required"))
  }
  
  def optional[B](f: T => B) = {
    decorator.map(f)
  }
  
}