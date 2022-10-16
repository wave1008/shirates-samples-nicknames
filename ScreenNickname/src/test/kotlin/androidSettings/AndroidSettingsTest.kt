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
                    it.tapAppIcon("Settings")
                        .existWithScrollDown("Battery||Accessibility||Passwords & accounts||Tips & support")
                }.action {
                    it.tapWithScrollDown("System")
                }.expectation {
                    it.exist("@Navigate up")
                        .exist("@System")
                }
            }
            case(2) {
                action {
                    it.tap("Languages & input")
                }.expectation {
                    it.exist("@Navigate up")
                        .exist("@Languages & input")
                }
            }
            case(3) {
                action {
                    it.tap("Languages")
                }.expectation {
                    it.exist("@Navigate up")
                        .exist("@Languages")
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
                    it.tapAppIcon("Settings")
                        .screenIs("[Android Settings Top Screen]")
                }.action {
                    it.tapWithScrollDown("[System]")
                }.expectation {
                    it.screenIs("[System Screen]")
                        .exist("[<-]")
                        .exist("[System]")
                }
            }
            case(2) {
                action {
                    it.tap("[Languages & input]")
                }.expectation {
                    it.screenIs("[Languages & input Screen]")
                        .exist("[Languages]")
                }
            }
            case(3) {
                action {
                    it.tap("[Languages]")
                }.expectation {
                    it.screenIs("[Languages Screen]")
                }
            }
        }
    }

}