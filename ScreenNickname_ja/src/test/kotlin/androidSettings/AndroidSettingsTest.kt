package androidSettings

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

class AndroidSettingsTest : UITest() {

    @Test
    @Order(10)
    fun withoutNickname() {

        scenario {
            case(1) {
                condition {
                    it.tapAppIcon("設定")
                        .existWithScrollDown("バッテリー||ユーザー補助||パスワードとアカウント||ヒントとサポート")
                }.action {
                    it.tapWithScrollDown("システム")
                }.expectation {
                    it.exist("@上へ移動")
                        .exist("@システム")
                }
            }
            case(2) {
                action {
                    it.tap("言語と入力")
                }.expectation {
                    it.exist("@上へ移動")
                        .exist("@言語と入力")
                        .select("{言語}").textStartsWith("日本語")
                }
            }
            case(3) {
                action {
                    it.tap()
                }.expectation {
                    it.exist("@上へ移動")
                        .exist("@言語")
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
                    it.tapAppIcon("設定")
                        .screenIs("[Android設定トップ画面]")
                }.action {
                    it.tapWithScrollDown("[システム]")
                }.expectation {
                    it.screenIs("[システム画面]")
                        .exist("[←]")
                        .exist("[システム]")
                }
            }
            case(2) {
                action {
                    it.tap("[言語と入力]")
                }.expectation {
                    it.screenIs("[言語と入力画面]")
                        .exist("[言語]")
                        .select("{言語}").textStartsWith("日本語")
                }
            }
            case(3) {
                action {
                    it.tap()
                }.expectation {
                    it.screenIs("[言語画面]")
                }
            }
        }
    }

}