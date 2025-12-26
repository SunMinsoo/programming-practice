export interface ValidationRule {
    id: string;
    label: string;
    isValid: boolean;
}

export interface PasswordValidation {
    rules: ValidationRule[];
    kisaValid: boolean;
    hasInvalidChars: boolean;
}