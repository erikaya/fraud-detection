import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should send a fraud"
    label "trigger_fraud"
    input {
        triggeredBy "trigger()"
    }

    outputMessage {
        sentTo "frauds"
        body(name: "m")
    }
}