package com.qw.utils

import org.junit.Test
import java.io.Serializable

/**
 * Created by qinwei on 2023/10/9 17:15
 * email: qinwei_it@163.com
 */
class OtherTest {
    @Test
    fun test() {
        println("${TabManager.genSectionTabs(29, 30).last().label()}")
        println("${TabManager.genSectionTabs(30, 30).last().label()}")
        println("${TabManager.genSectionTabs(31, 30).last().label()}")
        println("${TabManager.genSectionTabs(32, 30).last().label()}")
        println("${TabManager.genSectionTabs(89, 30).last().label()}")
    }
}

data class SectionTab(val start: Int, val end: Int) : ITab, Serializable {
    override fun label(): String {
        if (start == end) {
            return (end + 1).toString()
        }
        return "${start + 1}-${end + 1}"
    }

    fun `in`(position: Int): Boolean {
        return position in start..end
    }
}

interface ITab {
    fun label(): String
}

object TabManager {
    fun genSectionTabs(size: Int, group: Int = 30): ArrayList<ITab> {
        val tabs = ArrayList<ITab>()
        //构建sections  索引从0开始所以要-1
        //区间为30
        var i = 0
        while (i < size) {
            val start = i
            var end = i + group - 1
            if (end >= size) {
                end = size - 1
            }
            tabs.add(SectionTab(start, end))
            i += group
        }
        return tabs
    }
}