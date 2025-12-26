import type { ValidationRule } from "../types/password";

interface ValidationListProps {
    rules: ValidationRule[];
}

const ValidationList = ({rules}: ValidationListProps) => {
    return (
        <div className="validation-container">
            <strong>검증 항목 : </strong>
            <ul className="validation-list">
                {rules.map((rule) => (
                    <li
                        key={rule.id}
                        className={rule.isValid ? 'valid' : 'invalid'}
                    >
                        {rule.isValid ? 'O' : 'X'} {rule.label}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ValidationList;