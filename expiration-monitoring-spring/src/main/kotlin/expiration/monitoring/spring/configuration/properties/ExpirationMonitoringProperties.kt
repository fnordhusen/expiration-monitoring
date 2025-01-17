package expiration.monitoring.spring.configuration.properties

import io.micrometer.core.instrument.ImmutableTag
import org.springframework.boot.context.properties.ConfigurationProperties
import java.io.File
import java.util.Date

@ConfigurationProperties(value = "expiration.monitoring")
class ExpirationMonitoringProperties(
    val globalTags: List<ImmutableTag>?,
    val credentials: List<ExpiringCredentialProperties>?,
    val pkcs12Stores: List<ExpiringPkcs12Properties>?,
    val x509Certificates: List<ExpiringX509CertificateProperties>?,
    val plaintextX509Certificates: List<ExpiringPlaintextX509CertificateProperties>?,
)

class ExpiringPkcs12Properties(
    val name: String,
    val location: File,
    val password: String = ""
)

class ExpiringX509CertificateProperties(
    val name: String,
    val location: File
)

class ExpiringPlaintextX509CertificateProperties(
    val name: String,
    val content: String
)

class ExpiringCredentialProperties(
    val name: String,
    val expirationDate: Date
)
