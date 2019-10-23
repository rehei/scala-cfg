package com.github.rehei.scala.cfg

import scala.reflect.runtime.universe._

trait ConfigSupport {

  private var decorators: Map[Type, AnyRef] = Map[Type, AnyRef]()

  protected def decorateWith[T <: AnyRef](decorator: T)(implicit tag: TypeTag[T]): this.type = {
    val keyValue = (tag.tpe, decorator)
    val newDecorators = decorators + keyValue

    val copy = this.getClass().newInstance().asInstanceOf[this.type]
    copy.injectDecorators(newDecorators)
    copy
  }

  protected def getDecorator[T <: AnyRef](implicit tag: TypeTag[T]): Option[T] = {
    decorators.get(tag.tpe).map { _.asInstanceOf[T] }
  }

  private def injectDecorators(injectable: Map[Type, AnyRef]) {
    this.decorators = injectable
  }

}