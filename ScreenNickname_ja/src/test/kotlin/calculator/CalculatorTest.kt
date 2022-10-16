package calculator

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class CalculatorTest : UITest() {

    @Test
    @Order(10)
    fun withoutNickname() {

        scenario {
            case(1) {
                condition {
                    it.tapAppIcon("電卓")
                }.expectation {
                    it.exist("#clr")
                    it.exist("#parens")
                }
            }
            case(2) {
                action {
                    it.tap("#clr")
                }.expectation {
                    it.select("#formula")
                        .textIsEmpty()
                    it.select("#result_preview")
                        .textIsEmpty()
                }
            }
            case(3) {
                action {
                    it.tap("#digit_1")
                }.expectation {
                    it.select("#formula")
                        .textIs("1")
                    it.select("#result_preview")
                        .textIsEmpty()
                }
            }
            case(4) {
                action {
                    it.tap("#op_add")
                }.expectation {
                    it.select("#formula")
                        .textIs("1+")
                    it.select("#result_preview")
                        .textIsEmpty()
                }
            }
            case(5) {
                action {
                    it.tap("#digit_2")
                }.expectation {
                    it.select("#formula")
                        .textIs("1+2")
                    it.select("#result_preview")
                        .textIs("3")
                }
            }
            case(6) {
                action {
                    it.tap("#eq")
                }.expectation {
                    it.select("#result_final")
                        .textIs("3")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun withNickname() {

        scenario {
            case(1) {
                condition {
                    it.tapAppIcon("電卓")
                }.expectation {
                    it.screenIs("[電卓メイン画面]")
                }
            }
            case(2) {
                action {
                    it.tap("[AC]")
                }.expectation {
                    it.select("[計算式]")
                        .textIsEmpty()
                    it.select("[計算結果プレビュー]")
                        .textIsEmpty()
                }
            }
            case(3) {
                action {
                    it.tap("[1]")
                }.expectation {
                    it.select("[計算式]")
                        .textIs("1")
                    it.select("[計算結果プレビュー]")
                        .textIsEmpty()
                }
            }
            case(4) {
                action {
                    it.tap("[+]")
                }.expectation {
                    it.select("[計算式]")
                        .textIs("1+")
                    it.select("[計算結果プレビュー]")
                        .textIsEmpty()
                }
            }
            case(5) {
                action {
                    it.tap("[2]")
                }.expectation {
                    it.select("[計算式]")
                        .textIs("1+2")
                    it.select("[計算結果プレビュー]")
                        .textIs("3")
                }
            }
            case(6) {
                action {
                    it.tap("[=]")
                }.expectation {
                    it.select("[計算結果]")
                        .textIs("3")
                }
            }
        }
    }
}