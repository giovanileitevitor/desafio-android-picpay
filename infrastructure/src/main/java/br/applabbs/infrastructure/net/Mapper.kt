package br.applabbs.infrastructure.net

abstract class Mapper<CLASS_IN, CLASS_OUT> {
    abstract fun transform(item: CLASS_IN): CLASS_OUT
}
