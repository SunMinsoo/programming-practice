interface KisaResultProps {
    kisaValid: boolean;
    hasInvalidChars: boolean;
    password: string;
}

const KisaResult = ({kisaValid, hasInvalidChars, password}: KisaResultProps) => {
    if (!password) {
        return null;
    }

    let resultText: string;

    if (hasInvalidChars) {
        resultText = '불가';
    } else if (!kisaValid) {
        resultText = '불충분';
    } else {
        resultText = '통과';
    }

    return (
        <div className="kisa-container">
            <div className="kisa-result">
                {resultText}
            </div>
            {hasInvalidChars && (
                <div className="kisa-error">
                    한글이나 허용되지 않은 문자가 포함되어 있습니다.
                </div>
            )}
        </div>
    )
}

export default KisaResult;