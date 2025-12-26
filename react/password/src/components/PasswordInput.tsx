interface PasswordInputProps {
    value: string;
    onChange: (value: string) => void;
}

const PasswordInput = ({value, onChange}: PasswordInputProps) => {
    return (
        <div className="password-input-container">
            <label className="password-label">비밀번호 입력</label>
            <input
                type="text"
                value={value}
                onChange={(e) => onChange(e.target.value)}
                placeholder="비밀번호를 입력하세요"
                className="password-input"
            />
        </div>
    )
}

export default PasswordInput;