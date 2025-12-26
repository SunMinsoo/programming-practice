import type { PasswordValidation, ValidationRule } from '../types/password';

export const validatePassword = (password: string): PasswordValidation => {
    const hasInvalidChars = !/^[A-Za-z0-9!@#$%^&*]*$/.test(password);

    const rules: ValidationRule[] = [
        {
            id: 'length',
            label: '(필수) 8자 이상',
            isValid: password.length >= 8,
        },
        {
            id: 'uppercase',
            label: '(선택) 대문자 포함',
            isValid: /[A-Z]/.test(password),
        },
        {
            id: 'lowercase',
            label: '(선택) 소문자 포함',
            isValid: /[a-z]/.test(password),
        },
        {
            id: 'number',
            label: '(선택) 숫자 포함',
            isValid: /[0-9]/.test(password), 
        },
        {
            id: 'special',
            label: '(선택) 특수문자 포함',
            isValid: /[!@#$%^&*]/.test(password),
        }
    ];

    const hasLength = password.length >= 8;

    const categoryCount = [
        /[A-Z]/.test(password), 
        /[a-z]/.test(password),
        /[0-9]/.test(password), 
        /[!@#$%^&*]/.test(password)
    ].filter(Boolean).length;

    const kisaValid = hasLength && (categoryCount >= 3);

    return { rules, kisaValid, hasInvalidChars };
}

