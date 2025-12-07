def isValidParentheses(s):
    st = []
    for ch in s:
        if ch == '(':
            st.append(')')
        elif ch == '{':
            st.append('}')
        elif ch == '[':
            st.append(']')
        else:
            if not st or  st.pop() !=  ch:
                return False
    return len(st) == 0
print(isValidParentheses('[()]'))
print(isValidParentheses('[(]'))

