import { useMemo, useState } from 'react'
import type { FormEvent } from 'react'
import { Bell, CalendarDays, Check, CheckCircle2, CircleHelp, Clock3, Inbox, LayoutDashboard, ListTodo, MoreHorizontal, Plus, Search, Settings, Sun } from 'lucide-react'
import './App.css'

type Task = {
  id: number
  title: string
  project: string
  due: string
  priority: 'High' | 'Medium' | 'Low'
  completed: boolean
}

const initialTasks: Task[] = [
  { id: 1, title: 'Lên sơ đồ quy trình bắt đầu', project: 'Thiết kế sản phẩm', due: 'Hôm nay', priority: 'High', completed: false },
  { id: 2, title: 'Xem lại cách đặt tên API với nhóm', project: 'Ứng dụng Taskly', due: 'Hôm nay', priority: 'Medium', completed: false },
  { id: 3, title: 'Viết ghi chú từ các buổi phỏng vấn', project: 'Nghiên cứu', due: 'Ngày mai', priority: 'Low', completed: false },
  { id: 4, title: 'Thiết lập cấu trúc cơ sở dữ liệu', project: 'Ứng dụng Taskly', due: 'Hôm nay', priority: 'High', completed: true },
]

const priorityLabels: Record<Task['priority'], string> = {
  High: 'Cao',
  Medium: 'Trung bình',
  Low: 'Thấp',
}

function App() {
  const [tasks, setTasks] = useState(initialTasks)
  const [filter, setFilter] = useState<'all' | 'open' | 'done'>('all')
  const [newTask, setNewTask] = useState('')

  const visibleTasks = useMemo(() => tasks.filter((task) => {
    if (filter === 'open') return !task.completed
    if (filter === 'done') return task.completed
    return true
  }), [filter, tasks])

  const completedCount = tasks.filter((task) => task.completed).length
  const openCount = tasks.length - completedCount

  function toggleTask(id: number) {
    setTasks((current) => current.map((task) => task.id === id ? { ...task, completed: !task.completed } : task))
  }

  function addTask(event: FormEvent<HTMLFormElement>) {
    event.preventDefault()
    const title = newTask.trim()
    if (!title) return
    setTasks((current) => [{ id: Date.now(), title, project: 'Hộp thư', due: 'Hôm nay', priority: 'Medium', completed: false }, ...current])
    setNewTask('')
  }

  return (
    <div className="app-shell">
      <aside className="sidebar">
        <div className="brand"><span className="brand-mark">T</span><span>Taskly</span></div>
        <nav className="main-nav" aria-label="Điều hướng chính">
          <p className="nav-label">Không gian làm việc</p>
          <button className="nav-item active" type="button"><LayoutDashboard aria-hidden="true" /> Tổng quan</button>
          <button className="nav-item" type="button"><ListTodo aria-hidden="true" /> Việc của tôi <b>{openCount}</b></button>
          <button className="nav-item" type="button"><Sun aria-hidden="true" /> Hôm nay</button>
          <button className="nav-item" type="button"><Inbox aria-hidden="true" /> Hộp thư</button>
          <button className="nav-item" type="button"><CalendarDays aria-hidden="true" /> Lịch</button>
        </nav>
        <div className="projects">
          <p className="nav-label">Dự án <button className="tiny-action" type="button" aria-label="Thêm dự án">+</button></p>
          <button className="project-item" type="button"><i className="dot coral" /> Ứng dụng Taskly <span>8</span></button>
          <button className="project-item" type="button"><i className="dot green" /> Thiết kế sản phẩm <span>5</span></button>
          <button className="project-item" type="button"><i className="dot blue" /> Nghiên cứu <span>3</span></button>
        </div>
        <div className="sidebar-footer"><button className="nav-item" type="button"><Settings aria-hidden="true" /> Cài đặt</button><div className="profile"><span className="avatar">KS</span><span><strong>Kiều Vân Sơn</strong><small>Không gian cá nhân</small></span><MoreHorizontal className="more" aria-hidden="true" /></div></div>
      </aside>

      <main className="main-content">
        <header className="topbar"><div className="breadcrumb"><span>Không gian làm việc</span><b>/</b><strong>Tổng quan</strong></div><div className="top-actions"><button className="icon-button" type="button" aria-label="Tìm kiếm"><Search aria-hidden="true" /></button><button className="icon-button notification" type="button" aria-label="Thông báo"><Bell aria-hidden="true" /><i /></button><button className="help-button" type="button" aria-label="Trợ giúp"><CircleHelp aria-hidden="true" /></button></div></header>
        <div className="content-wrap">
          <section className="welcome"><div><p className="eyebrow">Thứ Tư, ngày 9 tháng 9, 2026</p><h1>Chào buổi sáng, Sơn<span>.</span></h1><p className="subtitle">Một bàn làm việc gọn gàng giúp bạn tập trung vào điều quan trọng hôm nay.</p></div><button className="primary-button" type="button" onClick={() => document.getElementById('new-task')?.focus()}><Plus aria-hidden="true" /> Thêm việc</button></section>
          <section className="metrics" aria-label="Tóm tắt công việc"><div className="metric"><span className="metric-icon sun"><Sun aria-hidden="true" /></span><div><strong>{openCount}</strong><span>Việc đang mở</span></div></div><div className="metric"><span className="metric-icon check"><CheckCircle2 aria-hidden="true" /></span><div><strong>{completedCount}</strong><span>Đã hoàn thành</span></div></div><div className="metric"><span className="metric-icon clock"><Clock3 aria-hidden="true" /></span><div><strong>4 giờ 20 phút</strong><span>Thời gian tập trung</span></div></div><div className="focus-progress"><div><span>Tiến độ tuần</span><strong>68%</strong></div><div className="progress-track"><span /></div></div></section>
          <section className="task-section"><div className="section-heading"><div><h2>Hôm nay</h2><p>Tập trung vào những việc quan trọng nhất.</p></div><div className="filters" role="group" aria-label="Lọc công việc">{(['all', 'open', 'done'] as const).map((option) => <button key={option} className={filter === option ? 'selected' : ''} type="button" onClick={() => setFilter(option)}>{option === 'all' ? 'Tất cả' : option === 'open' ? 'Đang làm' : 'Đã xong'}</button>)}</div></div>
            <form className="quick-add" onSubmit={addTask}><Plus aria-hidden="true" /><input id="new-task" value={newTask} onChange={(event) => setNewTask(event.target.value)} placeholder="Bạn cần làm gì?" aria-label="Tên công việc mới" /><select aria-label="Mức ưu tiên" defaultValue="Medium"><option value="Medium">Trung bình</option><option value="High">Cao</option><option value="Low">Thấp</option></select><button type="submit">Thêm việc</button></form>
            <div className="task-list">{visibleTasks.map((task) => <article className={`task-row ${task.completed ? 'is-complete' : ''}`} key={task.id}><button className="task-check" type="button" onClick={() => toggleTask(task.id)} aria-label={task.completed ? `Đánh dấu ${task.title} là đang làm` : `Hoàn thành ${task.title}`}>{task.completed && <Check aria-hidden="true" />}</button><div className="task-info"><strong>{task.title}</strong><span>{task.project}</span></div><span className="task-due">{task.due}</span><span className={`priority ${task.priority.toLowerCase()}`}><i />{priorityLabels[task.priority]}</span><button className="row-more" type="button" aria-label={`Tùy chọn cho ${task.title}`}><MoreHorizontal aria-hidden="true" /></button></article>)}</div>
            {visibleTasks.length === 0 && <div className="empty-state"><strong>Chưa có công việc nào</strong><span>Hãy thử bộ lọc khác hoặc thêm một việc mới ở trên.</span></div>}
          </section>
        </div>
      </main>
    </div>
  )
}

export default App
