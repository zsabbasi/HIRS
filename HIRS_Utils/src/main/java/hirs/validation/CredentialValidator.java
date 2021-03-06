package hirs.validation;

import hirs.data.persist.AppraisalStatus;
import hirs.data.persist.DeviceInfoReport;
import hirs.data.persist.certificate.EndorsementCredential;
import hirs.data.persist.certificate.PlatformCredential;

import java.security.KeyStore;

/**
 * A class used to support supply chain validation by performing the actual
 * validation of credentials.
 */
public interface CredentialValidator {
    /**
     * Checks if the platform credential is valid.
     *
     * @param pc The platform credential to verify.
     * @param trustStore trust store holding trusted certificates.
     * @param acceptExpired whether or not to accept expired certificates as valid.
     * @return The result of the validation.
     */
    AppraisalStatus validatePlatformCredential(PlatformCredential pc,
                                              KeyStore trustStore,
                                              boolean acceptExpired);

    /**
     * Checks if the platform credential's attributes are valid.
     * @param pc The platform credential to verify.
     * @param deviceInfoReport Report containing the serial numbers of the platform to be validated.
     * @param ec The endorsement credential supplied from the same identity request as
     *           the platform credential.
     * @return The result of the validation.
     */
    AppraisalStatus validatePlatformCredentialAttributes(PlatformCredential pc,
                                                         DeviceInfoReport deviceInfoReport,
                                                         EndorsementCredential ec);
    /**
     * Checks if the endorsement credential is valid.
     *
     * @param ec the endorsement credential to verify.
     * @param trustStore trust store holding trusted trusted certificates.
     * @param acceptExpired whether or not to accept expired certificates as valid.
     * @return the result of the validation.
     */
    AppraisalStatus validateEndorsementCredential(EndorsementCredential ec,
                                                       KeyStore trustStore,
                                                       boolean acceptExpired);
}
