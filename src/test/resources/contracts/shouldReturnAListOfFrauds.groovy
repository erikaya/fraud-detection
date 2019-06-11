import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url("/frauds")

    }

    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body(["marcin", "josh"])
    }
}